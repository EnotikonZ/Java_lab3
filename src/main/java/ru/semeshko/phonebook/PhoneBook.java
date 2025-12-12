package ru.semeshko.phonebook;

import java.util.*;

/**
 * Задание 2.3: Телефонный справочник.
 * Хранит пары "имя -> телефон".
 */
public class PhoneBook {

    private final Map<String, String> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    /**
     * Добавляет/заменяет контакт.
     * Если имя уже было — возвращает старый телефон, иначе null.
     */
    public String add(String phone, String name) {
        return contacts.put(name, phone);
    }

    public void remove(String name) {
        contacts.remove(name);
    }

    public String getPhone(String name) {
        return contacts.get(name);
    }

    public boolean containsName(String name) {
        return contacts.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        return contacts.containsValue(phone);
    }

    public int size() {
        return contacts.size();
    }

    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]);
    }

    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]);
    }

    public String[] getAllPairs() {
        List<String> pairs = new ArrayList<>();
        for (Map.Entry<String, String> e : contacts.entrySet()) {
            pairs.add(e.getValue() + " - " + e.getKey());
        }
        return pairs.toArray(new String[0]);
    }

    public String[] findNamesByPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        for (String name : contacts.keySet()) {
            if (name.startsWith(prefix)) res.add(name);
        }
        return res.toArray(new String[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : contacts.keySet()) {
            sb.append(contacts.get(name)).append(" - ").append(name).append("\n");
        }
        return sb.toString();
    }
}
