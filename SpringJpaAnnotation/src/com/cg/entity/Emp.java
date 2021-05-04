package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="cg_emp")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Emp {
	
	@Id
	@Column(name="emp_id")
	
	private Integer empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column(name="emp_sal")
	private Double empSal;
	
	@Column(name="emp_doj")
	private LocalDate empDoj;
	
	@ManyToOne
	@JoinColumn(name="did", referencedColumnName="dept_id")
	private Dept dept=new Dept();

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return empId+" "+empName+" "+empSal+" "+empDoj;
	}
}