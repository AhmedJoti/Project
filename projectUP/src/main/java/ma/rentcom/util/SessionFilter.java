package ma.rentcom.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import ma.rentcom.model.PersistenceEntity;

@SessionScoped
public class SessionFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Filter<? extends PersistenceEntity>> sessionMap = new HashMap<>();

	public void add(String key, Filter<? extends PersistenceEntity> value) {
		sessionMap.put(key, value);
	}

	public void clear(String key) {
		if (sessionMap.containsKey(key)) {
			sessionMap.put(key, null);
		}
	}

	public Filter<? extends PersistenceEntity> get(String key) {
		return sessionMap.get(key);
	}

}
