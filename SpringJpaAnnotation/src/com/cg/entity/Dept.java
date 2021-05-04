package com.cg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="cg_dept")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Dept {
	
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;
	
	@Column(name="dept_name", length=25)
	private String deptName;
	
	@OneToMany(mappedBy = "dept", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Emp> employees=new HashSet<>();

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
		return deptId+" "+deptName;
	}
}