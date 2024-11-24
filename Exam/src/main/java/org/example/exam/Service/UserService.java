package org.example.exam.Service;

import org.example.exam.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();




    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(String ID, User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getID().equals(ID)){
                users.set(i, user);
                return true;

            }
        }


        return false;

    }


    public boolean deleteUser(String ID){

        for(User u : users){

            if(u.getID().equals(ID)){
                users.remove(u);
                return true;
            }

        }

        return false;
    }



    public ArrayList<User> sameBalance(double balance){
        ArrayList<User> usersWithSameBalance = new ArrayList<>();

        for(User u : users){

            if(u.getBalance() == balance || u.getBalance() >= balance)

                usersWithSameBalance.add(u);

        }
        return usersWithSameBalance;
    }


    public ArrayList<User> sameAge(int age){

        ArrayList<User> usersSameAge = new ArrayList<>();

        for(User u : users){
            if(u.getAge() == age || u.getAge() >= age){
                usersSameAge.add(u);
            }
        }

        return usersSameAge;
    }











}
