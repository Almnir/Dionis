#!/bin/sh

XJC='/usr/bin/xjc'
PROJECT_PATH='/home/alm/workspace12345/Dionis'
XSD='src/dionis/xsd/Dionis.xsd'
OUT='src'
PACKAGE='dionis.xml'
BINDINGS='src/dionis/xsd/Dionis-JAXB-binding.xml'

$XJC $PROJECT_PATH/$XSD -d $PROJECT_PATH/$OUT -p $PACKAGE -no-header -b $PROJECT_PATH/$BINDINGS -XautoNameResolution
