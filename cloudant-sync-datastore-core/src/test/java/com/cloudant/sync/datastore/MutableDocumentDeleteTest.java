/**
 * Copyright (c) 2015 Cloudant, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.cloudant.sync.datastore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tomblench on 08/08/2014.
 */
public class MutableDocumentDeleteTest extends BasicDatastoreTestBase {

    BasicDocumentRevision saved;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MutableDocumentRevision rev = new MutableDocumentRevision();
        rev.docId = "doc1";
        rev.body = bodyOne;
        saved = datastore.createDocumentFromRevision(rev);
    }

    // Delete a MutableCopy
    @Test
    public void deleteFromRevision() throws ConflictException {
        BasicDocumentRevision deleted = datastore.deleteDocumentFromRevision(saved);
        Assert.assertNotNull("Deleted DocumentRevision is null", deleted);
        Assert.assertTrue("Deleted DocumentRevision is not flagged as deleted", deleted.isDeleted());
    }

    // Delete null
    @Test
    public void deleteNullRevision() throws ConflictException {
        try {
            BasicDocumentRevision deleted = datastore.deleteDocumentFromRevision(null);
            Assert.fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            ;
        }
    }

    // Try to delete based on a stale copy
    @Test
    public void deleteConflictRevision() throws Exception {
        MutableDocumentRevision update = saved.mutableCopy();
        update.body = bodyTwo;
        BasicDocumentRevision updatedStale = datastore.updateDocumentFromRevision(update);
        MutableDocumentRevision updateStale = updatedStale.mutableCopy();
        updateStale.attachments = null;
        updateStale.body = DocumentBodyFactory.create("{\"description\": \"this update will get committed\"}".getBytes());
        // this won't delete, will throw conflictexception
        datastore.updateDocumentFromRevision(updateStale);
        try {
            datastore.deleteDocumentFromRevision(updatedStale);
            Assert.fail("Expected ConflictException; not thrown");
        } catch (ConflictException ce) {
            ;
        }
    }

    // Delete all leaf revisions based on id
    @Test
    public void deleteAllFromRevision() throws Exception {
        // create 10 child docs
        for (int i=0;i<10;i++) {
            Map m = new HashMap<String, Object>();
            m.put("name", "conflicted");
            m.put("timestamp", System.currentTimeMillis());
            DocumentBody body = DocumentBodyFactory.create(m);
            DocumentRevisionBuilder builder = new DocumentRevisionBuilder();
            builder.setDocId(saved.getId());
            String newRev = "2-conflict-"+i;
            builder.setRevId(newRev);
            builder.setDeleted(false);
            builder.setBody(body);
            datastore.forceInsert(builder.build(), saved.getRevision(), newRev);
        }

        // assert on leaves in db before deleting
        Assert.assertEquals("Expected 10 leaves", 10, datastore.getAllRevisionsOfDocument(saved.getId()).leafs().size());
        for(BasicDocumentRevision rev : datastore.getAllRevisionsOfDocument(saved.getId()).leafRevisions()) {
            Assert.assertTrue("Expected rev to not be deleted", !rev.isDeleted());
        }
        // do the delete
        List<BasicDocumentRevision> deleted = datastore.deleteDocument(saved.getId());
        // assert on deleted documents returned
        Assert.assertEquals("Expected 10 leaves", 10, deleted.size());
        for(BasicDocumentRevision rev : deleted) {
            Assert.assertTrue("Expected rev to be deleted", rev.isDeleted());
        }
        // assert on leaves in db (should be same as those returned)
        for(BasicDocumentRevision rev : datastore.getAllRevisionsOfDocument(saved.getId()).leafRevisions()) {
            Assert.assertTrue("Expected rev to be deleted", rev.isDeleted());
        }
    }

    @Test
    public void deleteAllNullRevision() throws Exception {
        try {
            List<BasicDocumentRevision> deleted = datastore.deleteDocument(null);
            Assert.fail("NullPointerException expected");
        } catch (NullPointerException npe) {
            ;
        }
    }

    @Test
    public void deleteAllNonExistentRevision() throws Exception {
        List<BasicDocumentRevision> deleted = datastore.deleteDocument("abc123");
        Assert.assertEquals("Deleted list should be empty", true, deleted.isEmpty());

    }

}