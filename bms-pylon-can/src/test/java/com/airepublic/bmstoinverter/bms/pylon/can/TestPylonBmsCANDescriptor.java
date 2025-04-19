/**
 * This software is free to use and to distribute in its unchanged form for private use.
 * Commercial use is prohibited without an explicit license agreement of the copyright holder.
 * Any changes to this software must be made solely in the project repository at https://github.com/ai-republic/bms-to-inverter.
 * The copyright holder is not liable for any damages in whatever form that may occur by using this software.
 *
 * (c) Copyright 2022 and onwards - Torsten Oltmanns
 *
 * @author Torsten Oltmanns - bms-to-inverter''AT''gmail.com
 */
package com.airepublic.bmstoinverter.bms.pylon.can;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.airepublic.bmstoinverter.core.BMSConfig;
import com.airepublic.bmstoinverter.core.BMSDescriptor;
import com.airepublic.bmstoinverter.core.Port;
import com.airepublic.bmstoinverter.protocol.can.JavaCANPort;

/**
 * The {@link BMSDescriptor} for the JK BMS using the CAN protocol.
 */
public class TestPylonBmsCANDescriptor {
    private static final PylonBmsCANDescriptor desc = new PylonBmsCANDescriptor();

    @Test
    public void testName() {
        Assertions.assertEquals("PYLON_CAN", desc.getName());
    }


    @Test
    public void testBMSClass() {
        Assertions.assertEquals(PylonBmsCANProcessor.class, desc.getBMSClass());
    }


    @Test
    public void testPort() {
        final BMSConfig config = new BMSConfig(1, "", 500000, 200, desc);
        final Port port = desc.createPort(config);

        Assertions.assertEquals(JavaCANPort.class, port.getClass());
        Assertions.assertEquals(500000, port.getBaudrate());
    }

}
