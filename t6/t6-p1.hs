import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)

-- Gera retangulo SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeRect :: (String,Rect) -> String 
writeRect (style,((x,y),w,h)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera codigo-fonte de arquivo SVG 
-- concatenando uma lista de retangulos e seus atributos de estilo
writeRects :: Float -> Float -> [(String,Rect)] -> String 
writeRects w h rs = 
  printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeRect rs) ++ "</svg>"

{--
     O codigo+ abaixo cria um arquivo "colors.svg" com 2 retangulos.
     Para simplificar o exemplo, todos os atributos sao definidos manualmente,
     mas para gerar figuras maiores os atributos deverao ser calculados por funcoes.
 --}
main :: IO ()
main = do
  let
    style = "fill:rgb(140,0,0)"
    --rects = [(style,((10,10),50,50)),(style,((70,10),50,50)),(style,((130,10),50,50))]
    xs = [10,65..230]
    rects = [(style,((x,10),50,25)) | x <- xs]
    (w,h) = (1000,1000)
  writeFile "colors.svg" $ writeRects w h rects
  -- o codigo acima eh equivalente a:
  -- writeFile "colors.svg" (writeRects w h rects)