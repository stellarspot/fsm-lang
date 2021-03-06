package draw

import maze.MazeSpace
import maze.MazeField
import maze.Direction
import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer

fun draw(title: String = "FiniteStateMachine Maze Sample",
         width: Int = 800,
         height: Int = 600,
         space: MazeSpace) {

    application {
        configure {
            this.title = title
            this.width = width
            this.height = height
        }
        program {
            extend {
                draw(drawer, space)
            }
        }
    }
}

private fun draw(drawer: Drawer, space: MazeSpace) {

    val agent = space.agent
    val maze = space.maze

    drawer.background(ColorRGBa.WHITE)

    val width = drawer.bounds.width
    val height = drawer.bounds.height
    val size = Math.min(width, height) - 20
    drawer.translate((width - size) / 2, (height - size) / 2)
    val mazeSize = Math.max(maze.width, maze.height)
    val stepSize = size / mazeSize

    drawer.fill = ColorRGBa.WHITE
    drawer.stroke = ColorRGBa.BLACK

    var x1 = 0.0
    var y1 = 0.0
    var x2 = size
    var y2 = 0.0
    for (j in (0..maze.height)) {
        drawer.lineSegment(x1, y1, x2, y2)
        y1 += stepSize
        y2 += stepSize
    }

    x1 = 0.0
    y1 = 0.0
    x2 = 0.0
    y2 = size

    for (i in (0..maze.height)) {
        drawer.lineSegment(x1, y1, x2, y2)
        x1 += stepSize
        x2 += stepSize
    }

    fun getX(i: Int) = stepSize * i
    fun getY(j: Int) = size - stepSize * j - stepSize

    val r = stepSize / 2
    for (i in (0 until maze.width)) {
        for (j in (0 until maze.height)) {
            val x = getX(i)
            val y = getY(j)

            val field = maze[i, j]
            when (field) {
                MazeField.WALL -> {
                    drawer.lineSegment(x, y, x + stepSize, y + stepSize)
                    drawer.lineSegment(x, y + stepSize, x + stepSize, y)
                }
                MazeField.DOOR -> {
                    drawer.circle(x + r, y + r, r)
                }
            }
        }
    }

    drawer.stroke = ColorRGBa.BLUE

    val x = getX(agent.position.x) + r
    val y = getY(agent.position.y) + r

    val direction = agent.direction

    val rr = 0.8 * r
    val d = 5.0

    drawer.circle(x, y, rr)

    val dx = when (direction) {
        Direction.RIGHT -> rr
        Direction.LEFT -> -rr
        else -> 0.0
    }
    val dy = when (direction) {
        Direction.UP -> -rr
        Direction.DOWN -> rr
        else -> 0.0
    }
    drawer.lineSegment(x, y, x + dx, y + dy)
    drawer.circle(x + dx, y + dy, d)
}