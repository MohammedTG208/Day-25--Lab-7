package com.example.lab7week5.Service;

import com.example.lab7week5.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getAllUsers(){
        return users.isEmpty()?null:users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(User user,int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    //change status of isSubscribe to true
    public boolean changeSubscribe(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.get(i).setSubscribe(true);
                return true;
            }
        }
        return false;
    }

    //display only how has true only
    public ArrayList<User> displayHowSubscribe(){
        ArrayList<User> subscribeUser=new ArrayList<>();
        for(int i=0;i<users.size();i++){
            if(users.get(i).isSubscribe()){
                subscribeUser.add(users.get(i));
            }
        }
        return subscribeUser.isEmpty()?null:subscribeUser;
    }
    //check old password and set new password if it match
    public boolean changePassword(String oldPassword,String newPassword,int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id) {
                if (users.get(i).getPassword().equals(oldPassword)) {
                    users.get(i).setPassword(newPassword);
                    if (newPassword.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Search for one user by id
    public User getUser(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }

}
