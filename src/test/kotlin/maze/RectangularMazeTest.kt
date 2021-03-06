package maze

import org.junit.Test
import kotlin.test.assertEquals

class RectangularMazeTest {

    private val width = 3
    private val height = 3

    @Test
    fun testNextFieldUp() {

        assertEquals(MazeField.EMPTY,
                MazeSpace(
                        Agent(Position(1, 1), Direction.UP),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 2), MazeField.EMPTY))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 1), Direction.UP),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 2), MazeField.WALL))
                        )
                ).getInput()
        )

        assertEquals(MazeField.DOOR,
                MazeSpace(
                        Agent(Position(1, 1), Direction.UP),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 2), MazeField.DOOR))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 2), Direction.UP),
                        RectangularMaze(width, height)
                ).getInput()
        )
    }

    @Test
    fun testNextFieldDown() {
        assertEquals(MazeField.EMPTY,
                MazeSpace(
                        Agent(Position(1, 1), Direction.DOWN),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 0), MazeField.EMPTY))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 1), Direction.DOWN),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 0), MazeField.WALL))
                        )
                ).getInput()
        )

        assertEquals(MazeField.DOOR,
                MazeSpace(
                        Agent(Position(1, 1), Direction.DOWN),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(1, 0), MazeField.DOOR))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 0), Direction.DOWN),
                        RectangularMaze(width, height)
                ).getInput()
        )
    }

    @Test
    fun testNextFieldRight() {
        assertEquals(MazeField.EMPTY,
                MazeSpace(
                        Agent(Position(1, 1), Direction.RIGHT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(2, 1), MazeField.EMPTY))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 1), Direction.RIGHT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(2, 1), MazeField.WALL))
                        )
                ).getInput()
        )

        assertEquals(MazeField.DOOR,
                MazeSpace(
                        Agent(Position(1, 1), Direction.RIGHT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(2, 1), MazeField.DOOR))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(2, 1), Direction.RIGHT),
                        RectangularMaze(width, height)
                ).getInput()
        )
    }

    @Test
    fun testNextFieldLeft() {
        assertEquals(MazeField.EMPTY,
                MazeSpace(
                        Agent(Position(1, 1), Direction.LEFT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(0, 1), MazeField.EMPTY))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(1, 1), Direction.LEFT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(0, 1), MazeField.WALL))
                        )
                ).getInput()
        )

        assertEquals(MazeField.DOOR,
                MazeSpace(
                        Agent(Position(1, 1), Direction.LEFT),
                        RectangularMaze(width, height,
                                listOf(FieldPosition(Position(0, 1), MazeField.DOOR))
                        )
                ).getInput()
        )

        assertEquals(MazeField.WALL,
                MazeSpace(
                        Agent(Position(0, 1), Direction.LEFT),
                        RectangularMaze(width, height)
                ).getInput()
        )
    }
}