--1
addSuffix :: String -> [String] -> [String]
addSuffix suffix str = [x ++ suffix | x <- str]

--2
addSuffix' :: String -> [String] -> [String]
addSuffix' _ [] = []
addSuffix' suffix (x:xs) = (x ++ suffix) : addSuffix suffix xs 

--3
countShorts :: [String] -> Int
countShorts [] = 0
countShorts (x:xs)
	| length x < 5 = 1 + countShorts xs
	| otherwise = countShorts xs