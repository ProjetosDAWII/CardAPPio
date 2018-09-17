

INSERT INTO `categoria` (`idCategoria`, `categoriaNm`, `categoriaDesc`) VALUES
(1, 'Entradas', NULL),
(2, 'Pratos Principais', NULL),
(3, 'Bebidas', NULL),
(4, 'Sobremesas', NULL);

--
-- Dumping data for table `estoque`
--

INSERT INTO `estoque` (`idEstoque`, `notaFiscal_idNotaFiscal`, `idIngrediente`, `quantidade`, `dataFab`, `dataVenc`, `lote`, `unidade`, `idProduto`) VALUES
(1, 1, 1, 10000, '2018-09-17', '2018-09-19', 'gyn0898', 'gr', NULL);

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`idFornecedor`, `fornecedorNm`, `fornecedorEnd`, `fornecedorTel`) VALUES
(1, 'Casa de Carne Boi Feliz', 'Rua da vaca, bairro feliz, Goiânia-GO', '62 3333-0000');

--
-- Dumping data for table `ingrediente`
--

INSERT INTO `ingrediente` (`idIngrediente`, `ingredienteNm`, `ingredienteDesc`, `idFornecedor`) VALUES
(1, 'Patinho', 'Carne bovina magra de primeira', 1);

--
-- Dumping data for table `ingrediente_has_produto`
--

INSERT INTO `ingrediente_has_produto` (`produto_idProduto`, `estoque_idEstoque`, `quantidade`, `unidade`) VALUES
(1, 1, 300, 'gr');

--
-- Dumping data for table `notaFiscal`
--

INSERT INTO `notaFiscal` (`idNotaFiscal`, `tpNF`, `data`) VALUES
(1, 'Entrada', '2018-09-17');

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`idProduto`, `produtoNm`, `produtoDesc`, `idCategoria`, `idFornecedor`) VALUES
(1, 'Bife de patinho com molho de mostarda', 'Delicioso bifes de patinho, grelhados e cobertos por molho de mostarda.', 3, NULL);

