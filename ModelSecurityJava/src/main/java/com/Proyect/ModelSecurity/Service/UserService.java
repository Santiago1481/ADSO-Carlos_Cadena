package com.Proyect.ModelSecurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.interfaces.IUsers;
import com.Proyect.ModelSecurity.model.Users;

@Service
public class UserService {

    @Autowired
    private IUsers UsersData;

    //SELECT
    public List<Users> findAllUsers(){
        return UsersData.findAll();
    }

    //SELECT ID
    public Optional<Users> findByIdUsers(int Id){
        return UsersData.findById(Id);
    }

    //CREATE 
    public void save(Users Users){
        UsersData.save(Users);
    }

    //UPDATE
    public void update(int Id, Users usersUpdate){
        var Users  = findByIdUsers(Id);
        if (Users.isPresent()) {
            Users.get().setNameusers(usersUpdate.getNameusers());
            Users.get().setGmail(usersUpdate.getGmail());
            Users.get().setPasword(usersUpdate.getPasword());
            UsersData.save(Users.get());
        }

    }
 
    //DELETE
    public void delete(int Id){
        var Users = findByIdUsers(Id);
        if (Users.isPresent()) {
            UsersData.delete(Users.get());
        }
    }
}
