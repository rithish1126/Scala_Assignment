# Scala_Assignment

Q1)Bucketise the given array into buckets having range interval (x,x+0.0459)
'''
Buckets :
0.000 -0.049

0.050-0.099

0.100-0.149

0.150-0.199

0.200-0.249

0.250-0.299

0.300-0.349

0.350-0.399

100.000-100.049
'''

We notice that all the bucket bounds have a difference of 0.049 so we just take the input of the number and take the last two digits
to see if it falls in the bucket xx.00 - xx.x49 or xx.x50 - xx.x99 and print the buckets accordingly.

Q2)For given players statistics..
Found the below -
1. Player with the best highest run scored.
2. Top 5 players by run scored.
3. Top 5 players by wicket taken.
4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to
run scored

We use a case class in this case to have a blueprint of all the data values of a player and then create and array of player objects of this class and do the following operations on them.

1)Sort the array of objects in descending order based on the highest runs scored and return that object at the top
2)just like above but instead of printing the the object at the top we print the top 5 objects
3)Sort the array of objects in descending order based on the wickets taken and return the to 5 objects in the array
4)Sort the array of objects based on the constraints given in the question and then return the resultant array of objects
