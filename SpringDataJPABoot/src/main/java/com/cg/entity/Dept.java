package com.cg.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cg_dept_new")
public class Dept {
	@Id
	@Column(name = "dept_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;

	@Column(name = "deptName", length = 25)
	private String deptName;

	@OneToMany(mappedBy = "dept")
	
	private Set<Emp> employees;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return deptId + " " + deptName + " " ;
	}

}
