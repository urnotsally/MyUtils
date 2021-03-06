package com.wys.config;

/**
 * 模板文件的生成路径映射关系
 * @author xuyl
 * @date 2013-1-7
 */
public class TemplateMapping {
	private String template;
	private String dir;
	private String suffix = "java";		// default java
	private String packagePath;			// default calc from dir
	private String rpadding = "";		// padding the end of file name 
	private String lpadding = "";		// padding the start of file name 
	private boolean fixedName = false;  //是否固定文件名
	private String fileName ;//当fixedName为true时 文件名为fileName
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isFixedName() {
		return fixedName;
	}

	public void setFixedName(boolean fixedName) {
		this.fixedName = fixedName;
	}

	/**
	 * if packagePath is null, calculate result value of dir filed
	 * @author xuyl
	 * @date 2013-1-8
	 * @param groupId
	 * @param artifactId
	 * @return
	 */
	public String buildPackage(String groupId, String artifactId) {
		if (packagePath != null && ! packagePath.trim().isEmpty()) {
			return packagePath.replaceAll("\\$\\{groupId\\}", groupId).replaceAll("\\$\\{artifactId\\}", artifactId);
		}
		return buildDir(groupId, artifactId).replaceAll("[\\/]", ".");
	}

	/**
	 * replace parameter of '${project}' and '${model}'
	 * @author xuyl
	 * @date 2013-1-8
	 * @param groupId
	 * @param artifactId
	 * @return
	 */
	public String buildDir(String groupId, String artifactId) {
		return dir.replaceAll("\\$\\{groupId\\}",groupId ).replaceAll("\\.","/").replaceAll("\\$\\{artifactId\\}", artifactId);
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getRpadding() {
		return rpadding;
	}

	public void setRpadding(String rpadding) {
		this.rpadding = rpadding;
	}

	public String getLpadding() {
		return lpadding;
	}

	public void setLpadding(String lpadding) {
		this.lpadding = lpadding;
	}

	@Override
	public String toString() {
		return "{template=" + template + ", dir=" + dir + ", suffix=" + suffix + ", lpadding="
				+ lpadding + ", rpadding=" + rpadding + "}";
	}
}
