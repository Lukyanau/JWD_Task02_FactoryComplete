package by.epam_trining.lukyanau.task2.criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Criteria {
    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Object getValue(String searchCriteria) {
        return criteria.get(searchCriteria);
    }

    public Set<Map.Entry<String, Object>> getEntries() {
        return criteria.entrySet();
    }
}
