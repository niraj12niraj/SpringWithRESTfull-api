package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	static {
		users = populateDummyUsers();
	}

	public User findById(long id) {
		User s = null;
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			s = it.next();
			if (id == s.getId()) {
				System.out.println(
						"id " + s.getId() + " name " + s.getName() + " age " + s.getAge() + " salary " + s.getSalary());
				return s;
			}
		}
		// TODO Auto-generated method stub
		return s;
	}

	public User findByName(String name) {
		User s = null;
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			s = it.next();
			if (name == s.getName()) {
				System.out.println(
						"id " + s.getId() + " name " + s.getName() + " age " + s.getAge() + " salary " + s.getSalary());
				return s;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		//user.setId(user.getId());
		//user.setName(user.getName());
		//user.setAge(user.getAge());
		//user.setSalary(user.getSalary());
		//users.add(user);
		Iterator<User>it=users.iterator();
		while(it.hasNext()) {
		if(user.getId()==it.next().getId()) {
		users.add(new User(counter.incrementAndGet(),user.getName(),user.getAge(),user.getSalary()));}}
		System.out.println("user vsave successfully");
		// TODO Auto-generated method stub
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			if (user.getId() == it.next().getId()) {
				users.iterator().next().setId(user.getId());
				users.iterator().next().setName(user.getName());
				users.iterator().next().setAge(user.getAge());
				users.iterator().next().setSalary(user.getSalary());
			}
		}
		System.out.println("User updated successfully");

	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		Iterator<User>it=users.iterator();
		while(it.hasNext()) {
			if(id==it.next().getId()) {
				it.remove();
			}
		}
		System.out.println("User deleted successfully");


	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		Iterator<User>it=users.iterator();
		while(it.hasNext()) {
			findById(it.next().getId());
		}
		return null;
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		Iterator<User>it=users.iterator();
		while(it.hasNext()) {
		it.next();
		it.remove();
		}

	}

	public boolean isUserExist(User user) {
		boolean uExist=false;
		 Iterator<User>it=users.iterator();
		 while(it.hasNext()) {
			 if(user.getId()==it.next().getId()){
				 uExist=true;
				// System.out.println(uExist);
			 }
		 }
		 System.out.println(uExist);
			return uExist;
	}

	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
		users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
		return users;
	}

}
