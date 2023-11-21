package org.example.client;

public enum Commands {
    STX('\02'),//Start of Text
    ETX('\03'),//End of text
    ETB('\027'),//End of Transmission Block
    EOT('\004'),//End of Transmission
    ENQ('\005'),//Enquiry
    ACK('\006'),//Acknowledge
    NAK('\025'),//Negative Acknowledge
    CR('\r'),//Carriage Return
    LF('\n'),//Line Feed
    MOR('>'),//Greater Than (probably "more")
    FS('\034'),//File Separator
    GS('\035'),//Group Separator
    RS('\036'),//Record Separator
    SFS('\027'),//Specific Field Separator
    VT((char) 0x0B); //Vertical Tab (END OF BLOCK 011)
    private final char value;

    Commands(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
