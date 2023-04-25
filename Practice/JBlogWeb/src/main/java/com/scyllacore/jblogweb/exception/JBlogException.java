package com.scyllacore.jblogweb.exception;

public class JBlogException extends RuntimeException{
    private static final long serialVersionID = 1L;

    public JBlogException(String message){
        super(message);
    }

}
