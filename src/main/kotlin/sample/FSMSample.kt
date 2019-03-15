package sample

import maze.Agent
import maze.Direction
import maze.MazeAction
import maze.MazeSpace
import draw.draw
import fsm.core.BaseFiniteStateMachine
import fsm.core.FiniteStateMachine
import fsm.core.StateTransition
import maze.MazeField
import maze.FieldPosition
import maze.Position
import maze.RectangularMaze


fun main(args: Array<String>) {
    println("FiniteStateMachine Sample")

    val maze = RectangularMaze(5, 5, listOf(
            FieldPosition(Position(0, 0), MazeField.DOOR),
            FieldPosition(Position(4, 0), MazeField.WALL)))

    val fsm = getFSM()
    val agent = Agent(Position(2, 2), Direction.UP)
    val space = MazeSpace(agent, maze, fsm)
    space.moveAgent()
    space.moveAgent()
    space.moveAgent()

    draw("Maze", 800, 600, space)
}

// Simple FiniteStateMachine
// Go forward for empty cells and rotate right for walls
fun getFSM(): FiniteStateMachine<MazeField, MazeAction> {
    val fsm = BaseFiniteStateMachine<MazeField, MazeAction>()
    val initialState = fsm.initialState
    initialState.transitions.add(
            StateTransition(MazeField.EMPTY, initialState, MazeAction.FORWARD))
    initialState.transitions.add(
            StateTransition(MazeField.WALL, initialState, MazeAction.RIGHT))
    return fsm
}