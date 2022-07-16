#include "lander.h"
#include "uiDraw.h"

void Lander::applyGravity(float amount)
{
	velocity.setDy(velocity.getDy() - amount);
}

void Lander::applyThrustLeft()
{
	if (canThrust()) {
		velocity.setDx(velocity.getDx() + 0.1);

		fuel -= 1;
	}

}

void Lander::applyThrustRight()
{
	if (canThrust()){
		velocity.setDx(velocity.getDx() - 0.1);
		fuel -= 1;
	}
}

void Lander::applyThrustBottom()
{
	if (canThrust()) {
		velocity.setDy(velocity.getDy() + 0.3);
		fuel -= 1;
	}
}

void Lander::advance()
{
	point.setX(point.getX() + velocity.getDx()); // getdirection from velocity
	point.setY(point.getY() + velocity.getDy()); // get direction from velocity
}

bool Lander::canThrust()
{
	return (isAlive() && !isLanded() && fuel > 0);
}

void Lander::draw() const
{
	if (isAlive())
	{
		drawLander(point);
	}
}