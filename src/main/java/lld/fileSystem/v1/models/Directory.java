package lld.fileSystem.v1.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class Directory {

    private  Directory root;
    private String name;
    private Directory parent;
    private Map<String, Directory> subdirs = new HashMap<>();
    private Map<String, File> files = new HashMap<>();

    public Directory(Directory _parent, Directory _root) {
        this.parent = _parent;
        this.root = _root;
    }

    public Directory getDirectoryByName(String name){
        return subdirs.get(name);
    }

    private Directory getDirectoryByRelativePath(String path){
        String[] names = path.split("/");
        return null;
    }

    private String sanitizePath(String path){
        if(path.length() == 0) return path;

        StringBuilder sb = new StringBuilder();
        sb.append(path.charAt(0));
        for(int i=1; i<path.length(); i++){

        }
        return "";
    }
    public Directory getDirectoryByPath(String name){

        if(name.startsWith("./")) return getDirectoryByRelativePath(name.substring(2));
        else if(name.startsWith("/")) return root.getDirectoryByRelativePath(name.substring(1));

        return null;
    }
}
