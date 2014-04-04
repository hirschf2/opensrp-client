package org.ei.drishti.provider;

import android.view.View;
import android.view.ViewGroup;
import org.ei.drishti.view.contract.Person;

import java.util.List;

public interface SmartRegisterClientsProvider {

    public View getView(Person person, View parentView, ViewGroup viewGroup);

    public java.util.List<Person> getListItems();

    public void sort(String sortBy);

    public List<Person> filter(CharSequence cs);

    public void showSection(String section);
}
