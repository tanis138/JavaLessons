package com.tanis138.state;

public class StateRunner {

    public static void main(String[] args) {
        State state = StateAction.generateState();
        System.out.println(state);
        StateAction.printStateInfo(state);
    }
}
