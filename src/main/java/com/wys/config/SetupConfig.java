package com.wys.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

/**
 * load configuration from "config.json" file
 * @author xuyl
 * @date 2013-1-7
 */
public class SetupConfig {
	private static SetupConfig instance;
	// project work dir
	public static final String USER_DIR = System.getProperty("user.dir");	
	public static final String SEPARATOR = File.separator;
	
	private String groupId;
	private String artifactId;
	private String author = "admin";	// default 'admin'
	private String ignorePrefix;
	private DbConfig dbConfig;
	private String templateDir;
	private TemplateMapping[] mappings;
	private Group[] groups;

//	public static void main(String[] args) {
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(File.separator.equals("\\"));
//		//\WINDOWS\Temp
//	}


	/**
	 * private Construction
	 */
	private SetupConfig() {}
	
	/**
	 * load config.json file
	 * @author xuyl
	 * @date 2013-1-7
	 * @return
	 */
	private static String loadJson() {
		StringBuilder sb = new StringBuilder( );
		try {
	        BufferedReader in = new BufferedReader(new FileReader(USER_DIR + "/src/main/resources/config.json"));
	        String str;
	        while ((str = in.readLine()) != null) {
	        	int contentIndex = str.indexOf("//");		// 处理行注释
	        	if (contentIndex != -1) {
	        		str = str.substring(0, contentIndex);
	        	}
	        	sb.append(str);
	        }
	        in.close();
	    } catch (IOException e) {
	    	System.out.println("找不到配置文件:" + USER_DIR + "/src/main/resources/config.json");
	    }
        System.out.println(sb.substring(200,220));
		return sb.toString();

	}

	/**
	 * get singleton instance of SetupConfig
	 * @author xuyl
	 * @date 2013-1-7
	 * @return
	 */
	public static SetupConfig getInstance() {
		if (instance == null) {
			instance = new Gson().fromJson(loadJson(), SetupConfig.class);
		}
		return instance;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIgnorePrefix() {
		return ignorePrefix;
	}

	public void setIgnorePrefix(String ignorePrefix) {
		this.ignorePrefix = ignorePrefix;
	}

	public DbConfig getDbConfig() {
		return dbConfig;
	}

	public void setDbConfig(DbConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public TemplateMapping[] getMappings() {
		return mappings;
	}

	public void setMappings(TemplateMapping[] mappings) {
		this.mappings = mappings;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "SetupConfig [groupId=" +groupId +", artifactId"+artifactId+ ", author=" + author + ", ignorePrefix=" + ignorePrefix
				+ ",\n\tgroups=" + Arrays.toString(groups)
				+ ",\n\tdbConfig=" + dbConfig + ",\n\tmappings=" + Arrays.toString(mappings) + "]";
	}

	public static void main(String[] args) {

		System.out.println(getInstance());
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
}
