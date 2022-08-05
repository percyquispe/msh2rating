package com.example.msh2rating.service.impl;

import com.example.msh2rating.model.User;
import com.example.msh2rating.dto.UserRequest;
import com.example.msh2rating.dto.UserResponse;
import com.example.msh2rating.service.IUserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private static final String FILE_NAME = "src/main/resources/database.txt";

    @Override
    public UserResponse createUser(UserRequest usr) {
        CopyOnWriteArrayList<User> users = readingFile(FILE_NAME);
        String uuid = UUID.randomUUID().toString();
        UserResponse response = new UserResponse();
        response.setId(uuid);

        users.add(User.builder()
            .id(uuid)
            .name(usr.getName())
            .email(usr.getEmail())
            .cellPhone(usr.getCellPhone())
            .department(usr.getDepartment())
            .build()
        );

        savingFile(users, FILE_NAME);

        return response;
    }

    @Override
    public void updateUser(String id, UserRequest usr) {
        CopyOnWriteArrayList<User> users = readingFile(FILE_NAME);
        User tmpUser = getUserFromDB(users, id);

        if (tmpUser != null) {
            users.remove(tmpUser);
            users.add(User.builder()
                .id(id)
                .name(usr.getName())
                .email(usr.getEmail())
                .cellPhone(usr.getCellPhone())
                .department(usr.getDepartment())
                .build()
            );
            savingFile(users, FILE_NAME);
        }
    }

    @Override
    public void deleteUser(String id){
        CopyOnWriteArrayList<User> users = readingFile(FILE_NAME);
        User tmpUser = getUserFromDB(users, id);

        if (tmpUser != null) {
            users.remove(tmpUser);
            savingFile(users, FILE_NAME);
        }
    }

    @Override
    public CopyOnWriteArrayList<User> getUsers() {
        return readingFile(FILE_NAME);
    }

    private User getUserFromDB(CopyOnWriteArrayList<User> users, String id) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()) {
            User tmpUser = iterator.next();

            if(tmpUser.getId().equals(id)) {
                return tmpUser;
            }
        }

        return null;
    }

    private void savingFile(CopyOnWriteArrayList<User> users, String fileName) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(users);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}
    }

    private <T> CopyOnWriteArrayList<T> readingFile(String fileName) {
        CopyOnWriteArrayList<T> values = new CopyOnWriteArrayList<>();

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            values = (CopyOnWriteArrayList<T>) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {e.printStackTrace();
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();}

        return values;
    }
}