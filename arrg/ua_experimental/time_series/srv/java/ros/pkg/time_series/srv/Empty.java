/* auto-generated by gensrv_java from /home/dhewlett/ros/ua-ros-pkg/ua_experimental/time_series/srv/Empty.srv.  Do not edit! */
package ros.pkg.time_series.srv;

import java.nio.ByteBuffer;

public class Empty extends ros.communication.Service<Empty.Request, Empty.Response> 
{

public static String __s_getDataType() { return "time_series/Empty"; }
public static String __s_getMD5Sum() { return "d41d8cd98f00b204e9800998ecf8427e"; }

public String getDataType() { return Empty.__s_getDataType(); }
public String getMD5Sum() { return Empty.__s_getMD5Sum(); }

public static class Request extends ros.communication.Message
{


  public Request() {
 super();

  }
  public static java.lang.String __s_getDataType() { return "time_series/EmptyRequest"; }
  public static java.lang.String __s_getMD5Sum() { return ""; }
  public static java.lang.String __s_getMessageDefinition()
  {
    return 
    "\n" + 
    "";
  }
  public java.lang.String getDataType() { return __s_getDataType(); }
  public java.lang.String getMD5Sum()   { return __s_getMD5Sum(); }
  public java.lang.String getMessageDefinition() { return __s_getMessageDefinition(); }
  public static java.lang.String __s_getServerMD5Sum() { return ("d41d8cd98f00b204e9800998ecf8427e"); }
  public java.lang.String getServerMD5Sum() { return __s_getServerMD5Sum(); }
  public static java.lang.String  __s_getServiceDataType() { return ("time_series/Empty"); }
  public java.lang.String getServiceDataType() { return __s_getServiceDataType(); }
  public Request clone() {
    Request clone = (Request)super.clone();
    return clone;
  }

  public static java.util.Map<java.lang.String, java.lang.String> fieldTypes() {
         java.util.HashMap<java.lang.String, java.lang.String> m = new java.util.HashMap<java.lang.String, java.lang.String>  ();      return m;
  }

  public static java.util.Set<java.lang.String> submessageTypes() {
         java.util.HashSet<java.lang.String> s = new java.util.HashSet<java.lang.String>  ();      return s;
  }

  public void setTo(ros.communication.Message __m) {
    if (!(__m instanceof Request)) throw new RuntimeException("Invalid Type");
    Request __m2 = (Request) __m;
    }

  public int serializationLength() 
  {
    int __l = 0;
    return __l;
  }
  public void serialize(ByteBuffer bb, int seq) {
  }
  public void deserialize(ByteBuffer bb)  {
  }
}

public static class Response extends ros.communication.Message
{


  public Response() {
 super();

  }
  public static java.lang.String __s_getDataType() { return "time_series/EmptyResponse"; }
  public static java.lang.String __s_getMD5Sum() { return ""; }
  public static java.lang.String __s_getMessageDefinition()
  {
    return 
    "\n" + 
    "";
  }
  public java.lang.String getDataType() { return __s_getDataType(); }
  public java.lang.String getMD5Sum()   { return __s_getMD5Sum(); }
  public java.lang.String getMessageDefinition() { return __s_getMessageDefinition(); }
  public static java.lang.String __s_getServerMD5Sum() { return ("d41d8cd98f00b204e9800998ecf8427e"); }
  public java.lang.String getServerMD5Sum() { return __s_getServerMD5Sum(); }
  public static java.lang.String  __s_getServiceDataType() { return ("time_series/Empty"); }
  public java.lang.String getServiceDataType() { return __s_getServiceDataType(); }
  public Response clone() {
    Response clone = (Response)super.clone();
    return clone;
  }

  public static java.util.Map<java.lang.String, java.lang.String> fieldTypes() {
         java.util.HashMap<java.lang.String, java.lang.String> m = new java.util.HashMap<java.lang.String, java.lang.String>  ();      return m;
  }

  public static java.util.Set<java.lang.String> submessageTypes() {
         java.util.HashSet<java.lang.String> s = new java.util.HashSet<java.lang.String>  ();      return s;
  }

  public void setTo(ros.communication.Message __m) {
    if (!(__m instanceof Response)) throw new RuntimeException("Invalid Type");
    Response __m2 = (Response) __m;
    }

  public int serializationLength() 
  {
    int __l = 0;
    return __l;
  }
  public void serialize(ByteBuffer bb, int seq) {
  }
  public void deserialize(ByteBuffer bb)  {
  }
}

public Empty.Request createRequest() { return new Empty.Request(); }public Empty.Response createResponse() { return new Empty.Response(); }}

