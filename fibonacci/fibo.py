#!/usr/bin/python
import os,sys

def main():
	first,second,next,previous, result = 1,1,0,1,0
	a,b,c = 1,1,0
	fibstr = ""
	print "Hey"
	print "Reg a",a,"Reg b",b,"Reg c",c,"fibstr",fibstr
	counter = 0
	amount = 0
	while amount == 0:
		print "And now tell me, how much fibonacci numbers you want!"
		try:
			amount = int(raw_input())
			break
		except ValueError:
			print "Only numbers, please!"

	if amount == 0:
		print "OK then, goodbye!"
		sys.exit()
	print first
	print second

	while   counter < amount:
		print next
		a = first
		b = second 
		first = b
		second = a + b
		next = first + second
		counter = counter+1
		
	sys.exit()			
		
	

if __name__ == "__main__":
	main()

