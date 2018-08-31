package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Module")
public class ModuleModel {
	private int id;
	private String name;
	private String target;
	
	private List<FunctionModel> functions = null;
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FunctionModel> getFunctions() {
		return functions;
	}

	public void setFunctions(List<FunctionModel> functions) {
		this.functions = functions;
	}
	
	
}
