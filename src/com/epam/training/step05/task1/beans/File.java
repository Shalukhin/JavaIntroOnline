package step05.task1.beans;

public abstract class File {
	
	private String name;
	private Directory directory;	
	
	public File() {
		super();
	}

	public File(String name, Directory directory) {
		super();
		this.name = name;
		this.directory = directory;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	
	
	
	

}
