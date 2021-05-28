import styled from 'styled-components';
import Graph from './Graph';

const ChartModal = () => {
  return (
    <ModalWrap>
      <ModalInfo>
        <h4>가격 범위</h4>
        <Text title="true">$1,000 - $1,000,000+</Text>
        <Text title="">평균 1박 요금은 $10,000 입니다.</Text>
      </ModalInfo>
      <Graph />
    </ModalWrap>
  );
};

export default ChartModal;

interface text {
  title: string;
}

const ModalWrap = styled.div`
  width: 493px;
  height: 364px;
  padding: 52px 64px 64px 64px;
  background-color: ${({ theme }) => theme.color.white};
  position: absolute;
  top: 128%;
  right: -85%;
`;

const ModalInfo = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 89px;

  h4 {
    font-size: ${({ theme }) => theme.fontSize.l};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    padding-bottom: 1rem;
  }
`;

const Text = styled.span<text>`
  padding: 2px 0;
  color: ${({ theme, title }) =>
    title ? theme.color.black : theme.color.gray3};
  font-size: ${({ theme, title }) =>
    title ? theme.fontSize.l : theme.fontSize.m};
`;
