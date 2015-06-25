/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mojespolecnost.tmproject.utils;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Provides free port for TJWS.
 * <br>
 * <br>
 * Project: diy-mw-core-clients <br>
 * Autor: mark <br>
 * Created: 21.05.2012 <br>
 * <br>
 */
public class RemoteUtil {

    public static int findFreePort() throws IOException {
        ServerSocket server = new ServerSocket(0);
        int port = server.getLocalPort();
        server.close();
        return port;
    } 
}
