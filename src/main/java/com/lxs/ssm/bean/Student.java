package com.lxs.ssm.bean;

public class Student {
	
	
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String stuName, String stuAdd) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.stuAdd = stuAdd;
	}

	private Integer id;

    private String stuName;

    private String stuAdd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuAdd() {
        return stuAdd;
    }

    public void setStuAdd(String stuAdd) {
        this.stuAdd = stuAdd == null ? null : stuAdd.trim();
    }
}