#!/bin/sh
cd culturarteWeb;
ant cleanall;
ant build-project;
ant build-war;
cd ..;
cd dispositivoMovil;
ant cleanall;
ant build-project;
ant build-war;
cd ..;
cd workstation;
ant build-jar;
ant build-project;

