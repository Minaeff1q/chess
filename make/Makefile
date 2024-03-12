COMP=g++ 
FLAGS=-Wall

all: chess.out debug.out

chess.out: chess.cpp libchess.cpp
	$(COMP) $(FLAGS) -o chess.out chess.cpp libchess.cpp

debug.out: chess.cpp libchess.cpp
	$(COMP) $(FLAGS) -o debug.out -g chess.cpp libchess.cpp

clean: 
	rm -f chess.out debug.out

.PHONY: clean
