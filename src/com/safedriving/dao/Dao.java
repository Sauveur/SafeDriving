package com.safedriving.dao;

import java.util.List;

public interface Dao<T> {
	void ajouter(T t);
	T trouverParId(Long id);
	List<T> lister();
	void maj(T t);
	void supprimer(T t);
}
