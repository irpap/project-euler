sumOfSquares::[Integer] -> Integer
sumOfSquares xs = sum [square x | x <- xs ]

squareOfSums:: [Integer] -> Integer
squareOfSums xs = square $ sum xs

square:: Integer -> Integer
square x = x * x

main = do
    print $ squareOfSums [1..100] - sumOfSquares [1..100]