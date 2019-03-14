package fsm.core

interface Action
interface Input

data class StateTransition<I : Input, A : Action>(
        val input: I,
        val nextState: State<I, A>,
        val action: A)

data class State<I : Input, A : Action>(
        val name: String,
        val transitions: MutableList<StateTransition<I, A>> = mutableListOf())

interface FSM<I : Input, A : Action> {

    val initialState: State<I, A>
    val states: MutableList<State<I, A>>
}

class BaseFSM<I : Input, A : Action> : FSM<I, A> {
    override val initialState = State<I, A>("Initial")
    override val states = mutableListOf<State<I, A>>()
}