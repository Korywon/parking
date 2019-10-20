package com.github.korywon.parking.controller.state;

import com.github.korywon.parking.utility.CommandListener;

import java.util.List;

/**
 * StateNode class to hold the basic properties of a node.
 * @author Alvin Huynh
 */
public abstract class StateNode {
    public StateNode(String transitionCommand) {
        this.transitionCommand = transitionCommand;
        commandListener = new CommandListener();
    }

    public StateNode launch() {
        init();
        start();
        return exit();
    }

    /**
     * List of nodes that the current node can transition to.
     */
    protected List<StateNode> transitionNodes;

    /**
     * Next node to transition to once a terminal state has been reached.
     */
    protected StateNode nextNode;

    /**
     * Command that is00000000000000000 or was used to transition to this node.
     */
    protected String transitionCommand;

    /**
     * Object to handle command inputs from the console.
     */
    protected CommandListener commandListener;

    /**
     * Initialization of the state node.
     */
    public abstract void init();

    /**
     * Main execution body of the node. Logic is placed in here to determine the next node.
     */
    public abstract void start();

    /**
     * Exit code to be executed right before terminal state of node is reached.
     * @return Returns a <code>StateNode</code> object signifying the next node to go to. If null, terminate the
     * state machine completely.
     */
    public abstract StateNode exit();
}
