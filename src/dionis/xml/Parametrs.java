
package dionis.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ports">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIO" maxOccurs="99" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Number">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="99"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Speed" type="{}PortSpeedType"/>
 *                             &lt;element name="Bits">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;minInclusive value="7"/>
 *                                   &lt;maxInclusive value="8"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Control" type="{}PortsSIOControlType"/>
 *                             &lt;element name="Parity" type="{}PortsSIOParityType"/>
 *                             &lt;element name="Direction" type="{}PortsSIODirectionType"/>
 *                             &lt;element name="Stop-bit" type="{}PortStopBitType"/>
 *                             &lt;element name="Modem">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="78"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SYN" maxOccurs="99" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Number">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="99"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Base_consts">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IP" type="{}IPType"/>
 *                   &lt;element name="MSS">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *                         &lt;minInclusive value="512"/>
 *                         &lt;maxInclusive value="8192"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Window">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *                         &lt;minInclusive value="1024"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TTL">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;minInclusive value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TCB">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *                         &lt;minInclusive value="16"/>
 *                         &lt;maxInclusive value="450"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TCBBuf">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                         &lt;minInclusive value="8"/>
 *                         &lt;maxInclusive value="64"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Proxy">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                         &lt;minInclusive value="8"/>
 *                         &lt;maxInclusive value="225"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Cluster">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Mode" type="{}ClusterModeType"/>
 *                             &lt;element name="Timer">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="60"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NAT">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Overload">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="(0.0.0.0|1.1.1.1|((25[0-5]|2[0-4]\d|[01]?\d\d?)\.){3}(25[0-5]|2[0-4]\d|[01]?\d\d?))"/>
 *                         &lt;minLength value="7"/>
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Limit" type="{}PortType"/>
 *                   &lt;element name="Size">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxInclusive value="32"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Table">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Static" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PAT" type="{}BooleanType"/>
 *                                       &lt;element name="Local">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="IP" type="{}IPType"/>
 *                                                 &lt;element name="Port" type="{}PortType"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Global">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="IP" type="{}IPType"/>
 *                                                 &lt;element name="Port" type="{}PortType"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Bits">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                             &lt;minInclusive value="0"/>
 *                                             &lt;maxInclusive value="32"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ARP">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Proxy" type="{}BooleanType"/>
 *                   &lt;element name="Table">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Static" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IP" type="{}IPType"/>
 *                                       &lt;element name="MAC" type="{}MACType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Tracing">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Interfaces">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Type">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Ethernet" type="{}BooleanType"/>
 *                                       &lt;element name="SLIP_PPP" type="{}BooleanType"/>
 *                                       &lt;element name="Loopback_Broadcast" type="{}BooleanType"/>
 *                                       &lt;element name="X.25" type="{}BooleanType"/>
 *                                       &lt;element name="ARP" type="{}BooleanType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Level">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Channel" type="{}BooleanType"/>
 *                                       &lt;element name="IP_ARP" type="{}BooleanType"/>
 *                                       &lt;element name="TCP_UDP_ICMP" type="{}BooleanType"/>
 *                                       &lt;element name="HEX-dump" type="{}BooleanType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Route">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Errors" type="{}BooleanType"/>
 *                             &lt;element name="All" type="{}BooleanType"/>
 *                             &lt;element name="Detail" type="{}BooleanType"/>
 *                             &lt;element name="HEX-dump" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Servers">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Telnet" type="{}BooleanType"/>
 *                             &lt;element name="TelnetD" type="{}BooleanType"/>
 *                             &lt;element name="DNS" type="{}BooleanType"/>
 *                             &lt;element name="DNSD" type="{}BooleanType"/>
 *                             &lt;element name="DHCPD" type="{}BooleanType"/>
 *                             &lt;element name="RIP" type="{}BooleanType"/>
 *                             &lt;element name="HTTPGW" type="{}BooleanType"/>
 *                             &lt;element name="IGMP" type="{}BooleanType"/>
 *                             &lt;element name="SNMP" type="{}BooleanType"/>
 *                             &lt;element name="ISAKMP" type="{}BooleanType"/>
 *                             &lt;element name="SNTP" type="{}BooleanType"/>
 *                             &lt;element name="DCP" type="{}BooleanType"/>
 *                             &lt;element name="Cluster" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Hosts">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Host" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Address">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="(Black_list|White_list|((25[0-5]|2[0-4]\d|[01]?\d\d?)\.){3}(25[0-5]|2[0-4]\d|[01]?\d\d?))"/>
 *                                   &lt;minLength value="7"/>
 *                                   &lt;maxLength value="15"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Name">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="(Interface|([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6})"/>
 *                                   &lt;minLength value="5"/>
 *                                   &lt;maxLength value="255"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="System_info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Full_name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Release" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Service" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Dionis_key_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Ports">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="X25" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="LAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SYN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="IPL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TCP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Cryptography">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Initialized" type="{}BooleanType"/>
 *                   &lt;element name="Kernel" type="{}BooleanType"/>
 *                   &lt;element name="Encryption">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IP" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Keep" type="{}BooleanType"/>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Serial">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                                             &lt;maxInclusive value="99999"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="Number">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *                                             &lt;maxInclusive value="99999"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Console">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Keyboard" type="{}ConsoleKeyboardType"/>
 *                   &lt;element name="Editor" type="{}ConsoleEditorType"/>
 *                   &lt;element name="Monitoring" type="{}ConsoleMonitoringType"/>
 *                   &lt;element name="Ports_led" type="{}ConsolePortsLedType"/>
 *                   &lt;element name="Time_led" type="{}ConsoleTimeLedType"/>
 *                   &lt;element name="Screen_blanking">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Inactive">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                   &lt;maxInclusive value="30"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Text">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="22"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Awake" type="{}ConsoleScreenBlankingAwakeType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AutoReset">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Day" type="{}WeekDayType"/>
 *                                       &lt;element name="Houre">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                             &lt;maxInclusive value="23"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Remote_Control">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="User">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="16"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Password">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="16"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Mode" type="{}RemoteControlModeType"/>
 *                   &lt;element name="Reload" type="{}BooleanType"/>
 *                   &lt;element name="Upload">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="128"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Download">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="128"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Keys">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Logs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Control">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="log" type="{}BooleanType"/>
 *                             &lt;element name="log_user" type="{}BooleanType"/>
 *                             &lt;element name="log_send" type="{}BooleanType"/>
 *                             &lt;element name="log_tcp" type="{}BooleanType"/>
 *                             &lt;element name="log_sess" type="{}BooleanType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Mode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Schedule">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Use" type="{}BooleanType"/>
 *                             &lt;element name="Item" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Day" type="{}WeekDayType"/>
 *                                       &lt;element name="Houre">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *                                             &lt;maxInclusive value="23"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Rename_to">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Parts" type="{}LogsPartsType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Password">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Send" type="{}PasswordGuessType"/>
 *                   &lt;element name="Freez" type="{}PasswordGuessType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Time_service">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Zone" type="{}TimeServiceZoneType"/>
 *                   &lt;element name="Name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="6"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Summer_name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="6"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Initialized" type="{}BooleanType"/>
 *                   &lt;element name="Summer" type="{}BooleanType"/>
 *                   &lt;element name="Auto" type="{}BooleanType"/>
 *                   &lt;element name="SNTP" type="{}BooleanType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Ping_probes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Probe" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IP" type="{}IPType"/>
 *                             &lt;element name="Interval" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Wait" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="Tag" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ports",
    "baseConsts",
    "nat",
    "arp",
    "tracing",
    "hosts",
    "systemInfo",
    "cryptography",
    "console",
    "remoteControl",
    "logs",
    "password",
    "timeService",
    "pingProbes"
})
public class Parametrs
    implements Serializable
{

    private final static long serialVersionUID = 33554432L;
    @XmlElement(name = "Ports", required = true)
    protected Ports ports;
    @XmlElement(name = "Base_consts", required = true)
    protected BaseConsts baseConsts;
    @XmlElement(name = "NAT", required = true)
    protected NAT nat;
    @XmlElement(name = "ARP", required = true)
    protected ARP arp;
    @XmlElement(name = "Tracing", required = true)
    protected Tracing tracing;
    @XmlElement(name = "Hosts", required = true)
    protected Hosts hosts;
    @XmlElement(name = "System_info", required = true)
    protected SystemInfo systemInfo;
    @XmlElement(name = "Cryptography", required = true)
    protected Cryptography cryptography;
    @XmlElement(name = "Console", required = true)
    protected Console console;
    @XmlElement(name = "Remote_Control", required = true)
    protected RemoteControl remoteControl;
    @XmlElement(name = "Logs", required = true)
    protected Logs logs;
    @XmlElement(name = "Password", required = true)
    protected Password password;
    @XmlElement(name = "Time_service", required = true)
    protected TimeService timeService;
    @XmlElement(name = "Ping_probes", required = true)
    protected PingProbes pingProbes;

    /**
     * Gets the value of the ports property.
     * 
     * @return
     *     possible object is
     *     {@link Ports }
     *     
     */
    public Ports getPorts() {
        return ports;
    }

    /**
     * Sets the value of the ports property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ports }
     *     
     */
    public void setPorts(Ports value) {
        this.ports = value;
    }

    public boolean isSetPorts() {
        return (this.ports!= null);
    }

    /**
     * Gets the value of the baseConsts property.
     * 
     * @return
     *     possible object is
     *     {@link BaseConsts }
     *     
     */
    public BaseConsts getBaseConsts() {
        return baseConsts;
    }

    /**
     * Sets the value of the baseConsts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseConsts }
     *     
     */
    public void setBaseConsts(BaseConsts value) {
        this.baseConsts = value;
    }

    public boolean isSetBaseConsts() {
        return (this.baseConsts!= null);
    }

    /**
     * Gets the value of the nat property.
     * 
     * @return
     *     possible object is
     *     {@link NAT }
     *     
     */
    public NAT getNAT() {
        return nat;
    }

    /**
     * Sets the value of the nat property.
     * 
     * @param value
     *     allowed object is
     *     {@link NAT }
     *     
     */
    public void setNAT(NAT value) {
        this.nat = value;
    }

    public boolean isSetNAT() {
        return (this.nat!= null);
    }

    /**
     * Gets the value of the arp property.
     * 
     * @return
     *     possible object is
     *     {@link ARP }
     *     
     */
    public ARP getARP() {
        return arp;
    }

    /**
     * Sets the value of the arp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ARP }
     *     
     */
    public void setARP(ARP value) {
        this.arp = value;
    }

    public boolean isSetARP() {
        return (this.arp!= null);
    }

    /**
     * Gets the value of the tracing property.
     * 
     * @return
     *     possible object is
     *     {@link Tracing }
     *     
     */
    public Tracing getTracing() {
        return tracing;
    }

    /**
     * Sets the value of the tracing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tracing }
     *     
     */
    public void setTracing(Tracing value) {
        this.tracing = value;
    }

    public boolean isSetTracing() {
        return (this.tracing!= null);
    }

    /**
     * Gets the value of the hosts property.
     * 
     * @return
     *     possible object is
     *     {@link Hosts }
     *     
     */
    public Hosts getHosts() {
        return hosts;
    }

    /**
     * Sets the value of the hosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hosts }
     *     
     */
    public void setHosts(Hosts value) {
        this.hosts = value;
    }

    public boolean isSetHosts() {
        return (this.hosts!= null);
    }

    /**
     * Gets the value of the systemInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SystemInfo }
     *     
     */
    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    /**
     * Sets the value of the systemInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemInfo }
     *     
     */
    public void setSystemInfo(SystemInfo value) {
        this.systemInfo = value;
    }

    public boolean isSetSystemInfo() {
        return (this.systemInfo!= null);
    }

    /**
     * Gets the value of the cryptography property.
     * 
     * @return
     *     possible object is
     *     {@link Cryptography }
     *     
     */
    public Cryptography getCryptography() {
        return cryptography;
    }

    /**
     * Sets the value of the cryptography property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cryptography }
     *     
     */
    public void setCryptography(Cryptography value) {
        this.cryptography = value;
    }

    public boolean isSetCryptography() {
        return (this.cryptography!= null);
    }

    /**
     * Gets the value of the console property.
     * 
     * @return
     *     possible object is
     *     {@link Console }
     *     
     */
    public Console getConsole() {
        return console;
    }

    /**
     * Sets the value of the console property.
     * 
     * @param value
     *     allowed object is
     *     {@link Console }
     *     
     */
    public void setConsole(Console value) {
        this.console = value;
    }

    public boolean isSetConsole() {
        return (this.console!= null);
    }

    /**
     * Gets the value of the remoteControl property.
     * 
     * @return
     *     possible object is
     *     {@link RemoteControl }
     *     
     */
    public RemoteControl getRemoteControl() {
        return remoteControl;
    }

    /**
     * Sets the value of the remoteControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoteControl }
     *     
     */
    public void setRemoteControl(RemoteControl value) {
        this.remoteControl = value;
    }

    public boolean isSetRemoteControl() {
        return (this.remoteControl!= null);
    }

    /**
     * Gets the value of the logs property.
     * 
     * @return
     *     possible object is
     *     {@link Logs }
     *     
     */
    public Logs getLogs() {
        return logs;
    }

    /**
     * Sets the value of the logs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Logs }
     *     
     */
    public void setLogs(Logs value) {
        this.logs = value;
    }

    public boolean isSetLogs() {
        return (this.logs!= null);
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link Password }
     *     
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link Password }
     *     
     */
    public void setPassword(Password value) {
        this.password = value;
    }

    public boolean isSetPassword() {
        return (this.password!= null);
    }

    /**
     * Gets the value of the timeService property.
     * 
     * @return
     *     possible object is
     *     {@link TimeService }
     *     
     */
    public TimeService getTimeService() {
        return timeService;
    }

    /**
     * Sets the value of the timeService property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeService }
     *     
     */
    public void setTimeService(TimeService value) {
        this.timeService = value;
    }

    public boolean isSetTimeService() {
        return (this.timeService!= null);
    }

    /**
     * Gets the value of the pingProbes property.
     * 
     * @return
     *     possible object is
     *     {@link PingProbes }
     *     
     */
    public PingProbes getPingProbes() {
        return pingProbes;
    }

    /**
     * Sets the value of the pingProbes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PingProbes }
     *     
     */
    public void setPingProbes(PingProbes value) {
        this.pingProbes = value;
    }

    public boolean isSetPingProbes() {
        return (this.pingProbes!= null);
    }

}
