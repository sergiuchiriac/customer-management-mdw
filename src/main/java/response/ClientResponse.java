/**
 * ClientResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package response;

public class ClientResponse  extends common.APIResponse  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private services.ClientElement[] clientElement;

    public ClientResponse() {
    }

    public ClientResponse(
           java.lang.String errorCode,
           java.lang.String message,
           java.lang.Boolean success,
           services.ClientElement[] clientElement) {
        super(
            errorCode,
            message,
            success);
        this.clientElement = clientElement;
    }


    /**
     * Gets the clientElement value for this ClientResponse.
     * 
     * @return clientElement
     */
    public services.ClientElement[] getClientElement() {
        return clientElement;
    }


    /**
     * Sets the clientElement value for this ClientResponse.
     * 
     * @param clientElement
     */
    public void setClientElement(services.ClientElement[] clientElement) {
        this.clientElement = clientElement;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientResponse)) return false;
        ClientResponse other = (ClientResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientElement==null && other.getClientElement()==null) || 
             (this.clientElement!=null &&
              java.util.Arrays.equals(this.clientElement, other.getClientElement())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getClientElement() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClientElement());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClientElement(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://response", "ClientResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientElement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response", "clientElement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://services", "ClientElement"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://services", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
