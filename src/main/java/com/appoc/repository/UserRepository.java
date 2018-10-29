package com.appoc.repository;
import com.appoc.model.Usuario;

import org.springframework.data.repository.CrudRepository;

//REPOSITÓRIO GLOBAL DE GERENCIAMENTO DE USUÁRIOS
public interface UserRepository extends CrudRepository<Usuario, String>{

	Usuario findById(long id);
	
	Usuario findByEmail(String email);
	
	
	//Role save(Role role);
	
	//Returns the number of entities available.
	long count();
	
	//	Deletes a given entity.
	void delete(Usuario entity);
	
	//	Deletes all entities managed by the repository.
	void deleteAll();
	
	//	Deletes the given entities.
	void deleteAll(Iterable<? extends Usuario> entities);

	//	Deletes the entity with the given id.
	void	deleteById(long id);
	
	//	Returns whether an entity with the given id exists.
	boolean	existsById(long id);
	
	//	Returns all instances of the type.
	Iterable<Usuario>	findAll();
	
	//	Returns all instances of the type with the given IDs.
	//  Iterable<User>	findAllById(Iterable<ID> ids);
	
	//	Retrieves an entity by its id.
	//  Optional <User>	findById(long id);

	//	Saves a given entity.
	//User save(User entity);
	
	//Saves all given entities.
	//Iterable<User> saveAll(Iterable<User> user);

}
