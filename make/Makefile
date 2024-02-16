CXX=g++
CXXFLAGS=-Wall -std=c++11

all: main clean

main: chess.cpp libchess.cpp
	$(CXX) $(CXXFLAGS) $^ -o chess.out

clean: 
	rm -f *.out