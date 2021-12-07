package com.phonebook;

import java.util.*;

public class PhoneBook
{
    static HashMap<String, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put("Udit","123");
        phoneMap.put("Raj","123");
    }
    Map<String, String> phoneMapEntries = phoneMap;

    public Optional<String> findPhoneNumberByName(String name)
    {
        if (phoneMapEntries.containsKey(name)) {
            return Optional.of(phoneMapEntries.get(name));
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {

        for (Map.Entry<String, String> entry : phoneMapEntries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }
    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneMapEntries +
                '}';
    }
}