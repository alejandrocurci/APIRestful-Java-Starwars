# API Restful - Java - Starwars characters

**Spring Framework - Persistance in json file**

This simple API loads some starwars characters from a json file and allows consumers to look for them. 

There is only one endpoint available, but param filters can be included:

(POST)    /find                         -> fetches all characters in the file

(POST)    /find?name=Skywalker          -> fetches all characters whose name contains "Skywalker"

(POST)    /find?homeworld=Tatooine      -> fetches all characters whose homeworld contains "Tatooine"

(POST)    /find?species=m               -> fetches all characters whose species contains "e"

Any amount of filters can be included at the same time. The search is case sensitive.
