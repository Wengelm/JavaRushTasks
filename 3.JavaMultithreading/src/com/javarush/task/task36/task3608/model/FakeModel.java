package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        User user1 = new User("12",1,2);
        User user2 = new User("123",1,2);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        modelData.setUsers(users);

    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
    @Override
    public void loadUserById(long userId)

        {
            throw new UnsupportedOperationException(); }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();

    }
}
