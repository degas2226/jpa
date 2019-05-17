package com.jpa.manytomany.usrperms.repos;

import com.jpa.manytomany.usrperms.entities.PaaUsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<PaaUsersEntity,Integer> {
}
