package org.ei.opensrp.cloudant.models;

import com.cloudant.sync.datastore.BasicDocumentRevision;

import org.ei.opensrp.clientandeventmodel.Obs;
import org.ei.opensrp.clientandeventmodel.User;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by koros on 3/16/16.
 */
public class Event extends org.ei.opensrp.clientandeventmodel.Event{

    // this is the revision in the database representing this task
    private BasicDocumentRevision rev;
    public BasicDocumentRevision getDocumentRevision() {
        return rev;
    }

    static final String DOC_TYPE = "org.ei.opensrp.cloudant.models.Event";
    private String type = DOC_TYPE;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Event(){

    }

    public Event(org.ei.opensrp.clientandeventmodel.Event event){
        setType(type);
        setDateCreated(event.getDateCreated());
        setVoided(event.getVoided());
        setBaseEntityId(event.getBaseEntityId());
        setEditor(event.getEditor());
        setCreator(event.getCreator());
        setDateEdited(event.getDateEdited());
        setVoider(event.getVoider());
        setDateVoided(event.getDateVoided());
        setVoidReason(event.getVoidReason());
        setDetails(event.getDetails());
        setEntityType(event.getEntityType());
        setFormSubmissionId(event.getFormSubmissionId());
        setLocationId(event.getLocationId());
        setEventDate(event.getEventDate());
        setEventType(event.getEventType());
        setEventId(event.getEventId());
        setObs(event.getObs());
        setProviderId(event.getProviderId());
        setVersion(event.getVersion());
    }

    public static final String type_key = "type";
    public static final String date_created_key = "date_created";
    public static final String voided_key = "voided";
    public static final String base_entity_id_key = "base_entity_id";
    public static final String editor_key = "editor";
    public static final String creator_key = "creator";
    public static final String date_edited_key = "date_edited";
    public static final String voider_key = "voider";
    public static final String date_voided_key = "date_voided";
    public static final String void_reason_key = "void_reason";
    public static final String details_key = "void_reason";
    public static final String entity_type_key = "entity_type";
    public static final String form_submission_id_key = "form_submission_id";
    public static final String location_id_key = "location_id";
    public static final String event_date_key = "event_date";
    public static final String event_type_key = "event_type";
    public static final String event_id_key = "event_id";
    public static final String obs_key = "obs";
    public static final String provider_key = "provider";
    public static final String version_key = "version";

    public static Event fromRevision(BasicDocumentRevision rev) {
        Event event = new Event();
        event.rev = rev;
        // this could also be done by a fancy object mapper
        Map<String, Object> map = rev.asMap();
        if(map.containsKey(type_key) && map.get(type_key).equals(Client.DOC_TYPE)) {
            event.setType((String) map.get(type_key));
            event.setDateCreated((Date) map.get(date_created_key));
            event.setVoided((Boolean) map.get(voided_key));
            event.setBaseEntityId((String) map.get(base_entity_id_key));
            event.setEditor((User) map.get(editor_key));
            event.setCreator((User) map.get(creator_key));
            event.setDateEdited((Date) map.get(date_edited_key));
            event.setVoider((User) map.get(voider_key));
            event.setDateVoided((Date) map.get(date_voided_key));
            event.setVoidReason((String) map.get(void_reason_key));
            event.setDetails((Map<String, String>) map.get(details_key));
            event.setEntityType((String) map.get(entity_type_key));
            event.setFormSubmissionId((String) map.get(form_submission_id_key));
            event.setLocationId((String) map.get(location_id_key));
            event.setEventDate((DateTime) map.get(event_date_key));
            event.setEventType((String) map.get(event_type_key));
            event.setEventId((String) map.get(event_id_key));
            event.setObs((List<Obs>) map.get(map.get(obs_key)));
            event.setProviderId((String) map.get(provider_key));
            event.setVersion((Long) map.get(version_key));
            return event;
        }
        return null;
    }

    public Map<String, Object> asMap() {
        // this could also be done by a fancy object mapper
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(type_key, type);
        map.put(date_created_key, getDateCreated());
        map.put(voided_key, getVoided());
        map.put(base_entity_id_key, getBaseEntityId());
        map.put(editor_key, getEditor());
        map.put(creator_key, getCreator());
        map.put(date_edited_key, getDateEdited());
        map.put(voider_key, getVoider());
        map.put(date_voided_key, getDateVoided());
        map.put(void_reason_key, getVoidReason());
        map.put(details_key, getDetails());
        map.put(entity_type_key, getEntityType());
        map.put(form_submission_id_key, getFormSubmissionId());
        map.put(location_id_key, getLocationId());
        map.put(event_date_key, getEventDate());
        map.put(event_type_key, getEventType());
        map.put(event_id_key, getEventId());
        map.put(obs_key, getObs());
        map.put(provider_key, getProviderId());
        map.put(version_key, getVersion());
        return map;
    }
}
