import { TestBed } from '@angular/core/testing';

import { SportyShoesService } from './sporty-shoes.service';

describe('SportyShoesService', () => {
  let service: SportyShoesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SportyShoesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
