package cst438.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	long id;
	
	String name;
	String data;
	int sequence;
	
	public User() {
	}
	
	public User(String name, String data) {
		this.name = name;
		this.data = data;
		sequence = 0;
	}
	
	public User(User user) {
		this.name = user.name;
		this.data = user.data;
		this.sequence = user.sequence+1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", data=" + data + ", sequence=" + sequence + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sequence != other.sequence)
			return false;
		return true;
	}
	
}
