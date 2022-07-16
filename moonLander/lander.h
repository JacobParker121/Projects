#pragma once
#ifndef lander_h
#define lander_h
#include "point.h"
#include "velocity.h"
#include "ground.h"

using namespace std;

#define DEFAULT_FUEL 500
class Lander
{
	private:
		Point point;
		Velocity velocity;
		const Ground *ground;
 		

		bool alive;
		bool landed;
		int fuel;

	public:
		Lander() : point(0, 0), alive(true), landed(false), fuel(DEFAULT_FUEL)
		{
		}
		Point getPoint() const{ return point; }
		Velocity getVelocity() const { return velocity; }
		
		
		bool isAlive() const { return alive;}
		bool isLanded() const {return landed; }

		int getFuel() const { return fuel; }
		void setLanded(bool landed) { this->landed = landed; }
		void setAlive(bool alive) { this->alive = alive; }
		void setFuel(int fuel) { this->fuel = fuel; }
		void setGround(const Ground &g) {ground = &g; }
		void setPoint(Point p) { point = p; }

		void applyGravity(float amount);
		void applyThrustLeft();
		void applyThrustRight();
		void applyThrustBottom();

		void advance();

		bool canThrust();

		void draw() const;
};

#endif