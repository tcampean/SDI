package utils;

import java.io.*;

public class Message implements Serializable{

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String OK = "ok";
    public static final String ERROR = "error";


    private String header;
    private String body;
    private Object object;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Message() {
    }

    public Message(String header, String body) {
        this.header = header;
        this.body = body;
        this.object = null;
    }

    public Message(String header, String body, Object obj) {
        this.header = header;
        this.body = body;
        this.object = obj;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getObject()
    {
        return object;
    }

    @Override
    public String toString() {
        return "classes.Message{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", object='" + object+
                '}';
    }

    public void readFrom(InputStream is) throws IOException
    {
        objectInputStream = new ObjectInputStream(is);

        try {
            header = (String) objectInputStream.readObject();
            body = (String) objectInputStream.readObject();
            object = objectInputStream.readObject();


        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void writeTo(OutputStream os) throws IOException {

        objectOutputStream = new ObjectOutputStream(os);

        try {
            objectOutputStream.writeObject(header);
            objectOutputStream.writeObject(body);
            objectOutputStream.writeObject(object);
        }catch (IOException e)
        {
            //Thrown when there is nothing left to read
        }
    }

}

